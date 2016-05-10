

var icon_bus_stop = new Array();

/**
 * 地図を表示する
 */
function setMap() {


	var lat = 42.828717, lon = 141.652636;
	var latlon = new ZDC.LatLon(lat, lon);
	var initial_tky = ZDC.wgsTotky(latlon);
	map = new ZDC.Map(document.getElementById('ZMap'), {
		latlon : latlon,
		zoom : 6
	});



	 /* スケールバーを作成 */
    widget = new ZDC.ScaleBar();
    /* スケールバーを追加 */
    map.addWidget(widget);
    /* 中心点画像を作成 */
    widget = new ZDC.MapCenter();
    /* 中心点画像を追加 */
    map.addWidget(widget);

};
//
var marker = new Array();

/**
 * ViewPageで用いる
 * 投稿の情報に基づきピンを立て、対応する吹き出しを作る
 * @param contributionList
 * @param usersList
 */
function contribution(contributionList,usersList){


	var latlon = new ZDC.LatLon(42.828717, 141.652636);
    var initial_tky = ZDC.wgsTotky(latlon);

	info = new ZDC.MsgInfo(initial_tky,
			{
		html:"",
		offset:ZDC.Pixel(0,0)
			});

	map.addWidget(info);


	for(var i=0;i<contributionList.length;i++){

		//	吹き出しを作る
			var htmlsrc = '<div><p>'+usersList[i].name+'さんの投稿です</p></div>';
				htmlsrc +='<p>タイトル</p>';
				htmlsrc +='<p>'+contributionList[i].title+'</p>';
				htmlsrc +='<a href="../ContributionDetailPage/id/'+contributionList[i].id+'">詳細へ</a>';
				//投稿の座標にピンを立てる

			if(contributionList[i].id != 0){
				var lat =contributionList[i].latlon.center.y;
				var lon = contributionList[i].latlon.center.x;
				var latlon = new ZDC.LatLon(lat,lon);
				var contribution_tky = ZDC.wgsTotky(latlon);
				marker[i] = new ZDC.Marker(contribution_tky);

			map.addWidget(marker[i]);
			}

			ZDC.bind(
					marker[i],
					ZDC.MARKER_MOUSEUP,
					{
						latlon:contribution_tky,info:info,html:htmlsrc,},
						showInfoContribution

			);
	}
}

/**
 *吹き出しを表示する
 *contribution()の一部
 */
function showInfoContribution(){

	this.info.moveLatLon(this.latlon);
	this.info.setHtml(
			this.html
	);

	this.info.open();

};


/**
 * PostConfirmationで用いる
 * 現在位置表示用の地図を表示する
 * @param circle
 */
function currentMap(circle){
	var lat = circle.center.y;
	var lon = circle.center.x;

	var latlon = new ZDC.LatLon(lat, lon);
	var  current_tky = ZDC.wgsTotky(latlon);
	map = new ZDC.Map(document.getElementById('ZMap'), {
		latlon : latlon,
		zoom : 6
	});



    var marker = new ZDC.Marker(current_tky);

    map.addWidget(marker);

	 /* スケールバーを作成 */
    widget = new ZDC.ScaleBar();
    /* スケールバーを追加 */
    map.addWidget(widget);
    /* 中心点画像を作成 */
    widget = new ZDC.MapCenter();
    /* 中心点画像を追加 */
    map.addWidget(widget);


};


/**
 *ContributionDetailで用いる
 *バス亭の位置にピンを立てる
 * @param params
 */
function setBusStop(params){

	for (var i = 0; i < params.length; i++) {
		var busStopTky =ZDC.wgsTotky( new ZDC.LatLon(parseFloat(params[i].latlon.center.y),
				parseFloat(params[i].latlon.center.x)));
		icon_bus_stop[i] = new ZDC.Marker(busStopTky, {
			/* マーカのサイズに合わせて位置を調整する */
			offset : new ZDC.Pixel(-10, -16),
			custom : {
				base : {
					src : '../../img/icon_bus_stop.png'
				}
			}

		});
		icon_bus_stop[i].setTitle(params[i].busStopName);


		map.addWidget(icon_bus_stop[i]);

	}
};
/**
 * setBusStopの一部
 * 吹き出しの表示と吹き出し内の文章を作る
 */
function showInfoMsgBusStand() {
	this.info.moveLatLon(this.latlon);
	this.info.setHtml(
			'<div style="font-size:80%; line-height: 1.3;"><b>' + this.name + '</b><br>' +
			'</div>'
	);
	this.info.open();
};

/**
 * contirbuionDetailで用いる
 * バス亭とバスの運行ルートが全て地図内に収まるような位置を地図の中心とする
 * @param contribution
 * @param busStopList
 */
function setZoomAndLatlon(contribution,busStopList) {
	var latlons=[];
	latlons[0] =(ZDC.wgsTotky(new ZDC.LatLon(contribution.latlon.center.y,contribution.latlon.center.x)));
	for(i=1;i<busStopList.length+1;i++){
		latlons[i]=ZDC.wgsTotky(new ZDC.LatLon(busStopList[i-1].latlon.center.y,busStopList[i-1].latlon.center.x));
	}

	var adjust = map.getAdjustZoom(latlons);
	map.moveLatLon(adjust.latlon);
	map.setZoom(8);
};

/**
 * contirbuionDetailで用いる
 * 投稿の位置にピンを立てる
 * @param bean
 */
function setContribution(bean){
	var latlon = ZDC.wgsTotky( new ZDC.LatLon(bean.latlon.center.y,bean.latlon.center.x));

	mrk = new ZDC.Marker(latlon);

	map.addWidget(mrk);

};

/**
 * ContributionDetailで用いる
 * バスン運行ルートを表示する
 * @param params
 * @param color
 */
function setBusRoute(params,color){

	var routeName;

	var latlons=[];
	for(var i=0;i<params.length;i++){
		latlons.push(ZDC.wgsTotky(new ZDC.LatLon(params[i].latlon.center.y,params[i].latlon.center.x)));

	}

	/* 線を作成 */
	bus_route = new ZDC.Polyline( latlons,
			{
		strokeWeight: 5,
		strokeColor: color,
		lineOpacity: 0.5,
			});
	/* 線を地図に追加 */
	map.addWidget(bus_route);
}


