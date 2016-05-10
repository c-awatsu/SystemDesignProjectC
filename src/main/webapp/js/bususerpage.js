var map;// ZMap
var bus_route;// バスルートの線の座標
var msg_bus;// バスの吹き出しの情報
var msg_bus_stop;// バス停の吹き出しの情報
var icon_bus = new Array();// バスアイコンの情報
var icon_bus_stop = new Array();// バス停アイコンの情報

/**
 * mapをセットする
 */
function setMap() {

	var latlon = new ZDC.LatLon(42.828261389, 141.652161111);

	map = new ZDC.Map(document.getElementById('ZMap'), {
		latlon : latlon,
		zoom : 0,
		zoomRange : [ 11, 12, 13, 14, 15, 16, 17 ],
	});

	var getDevice = (function() {
		var ua = navigator.userAgent;
		if (ua.indexOf('iPhone') > 0 || ua.indexOf('iPod') > 0
				|| ua.indexOf('Android') > 0 && ua.indexOf('Mobile') > 0) {
			return 'sp';
		} else if (ua.indexOf('iPad') > 0 || ua.indexOf('Android') > 0) {
			return 'tab';
		} else {
			return 'other';
		}
	})();

	if (getDevice == 'other') {
		/* 通常のコントロールを作成 */
		widget_normal = new ZDC.Control({
			pos : {
				top : 10,
				left : 10
			},
			type : ZDC.CTRL_TYPE_NORMAL
		});
		/* コントロールを表示 */
		map.addWidget(widget_normal);
	}

	/* スケールバーを作成 */
	widget_scalebar = new ZDC.ScaleBar();
	/* スケールバーを追加 */
	map.addWidget(widget_scalebar);
	/* 中心点画像を作成 */
	widget_mapcenter = new ZDC.MapCenter();
	/* 中心点画像を追加 */
	map.addWidget(widget_mapcenter);

};

/**
 * バスアイコンをセットする
 *
 * @param params
 *            BusIconList
 */
function setBus(params) {

	var latlon = new ZDC.LatLon(42.828717, 141.652636);
	var tky = ZDC.wgsTotky(latlon);
	msg_bus = new ZDC.MsgInfo(tky, {
		html : "",
		offset : ZDC.Pixel(0, 0)
	});

	/* 吹き出しを追加 */
	map.addWidget(msg_bus);
	for (var i = 0; i < params.length; i++) {

		/* 吹き出しを作成 */
		var htmlsrc1 = '<table cellspacing="0">';
		htmlsrc1 += '<tr><td><b>' + params[i].routeName + '</b></td></tr>';
		htmlsrc1 += '<tr><td><b>' + params[i].byWayOf + '</b></td></tr>';
		htmlsrc1 += '<tr><td><br></td></tr>';
		if (params[i].delay < 0) {
			htmlsrc1 += '<tr><td>現在遅れの情報はありません</td></tr>';
		} else if (params[i].delay <= 1) {
			htmlsrc1 += '<tr><td>ひとつ前のバス停を</td></tr>';
			htmlsrc1 += '<tr><td><u>予定通り</u>通過しました</td></tr>';
		} else {
			htmlsrc1 += '<tr><td>ひとつ前のバス停を</td></tr>';
			htmlsrc1 += '<tr><td><u>' + params[i].delay
					+ '分遅れ</u>で通過しました</td></tr>';
		}
		htmlsrc1 += '</table>';

		var latlon = new ZDC.LatLon(parseFloat(params[i].latlon.center.y),
				parseFloat(params[i].latlon.center.x));
		var tky = ZDC.wgsTotky(latlon);

		var icon_bus_src;
		if (params[i].busCompanyId == 3) {
			icon_bus_src = ".././img/icon_bus.png";
		} else if (params[i].busCompanyId == 2) {
			icon_bus_src = ".././img/icon_bus2.png";
		} else if (params[i].busCompanyId == 1) {
			icon_bus_src = ".././img/icon_bus3.png";
		}

		icon_bus[i] = new ZDC.Marker(tky, {
			/* マーカのサイズに合わせて位置を調整する */
			offset : new ZDC.Pixel(-20, -13.5),
			custom : {
				base : {
					src : icon_bus_src
				}
			}
		});
		map.addWidget(icon_bus[i]);

		/* マーカがクリックされたら吹き出しを表示する関数を実行させる */
		ZDC.bind(icon_bus[i], ZDC.MARKER_MOUSEUP, {
			latlon : tky,
			info : msg_bus,
			html : htmlsrc1,
		}, showInfoBus);
	}
}

/**
 * バスの吹き出しを表示する
 */
function showInfoBus() {
	this.info.moveLatLon(this.latlon);
	this.info.setHtml(this.html);
	this.info.open();
};

/**
 * バス停アイコンをセットする
 *
 * @param params
 *            BusStopList
 */
function setBusStop(params) {
	var latlon = ZDC.wgsTotky(new ZDC.LatLon(
			parseFloat(params[0].latlon.center.y),
			parseFloat(params[0].latlon.center.x)));
	msg_bus_stop = new ZDC.MsgInfo(latlon, {
		offset : ZDC.Pixel(0, 0)
	});
	/* 吹き出しを追加 */
	map.addWidget(msg_bus_stop);

	for (var i = 0; i < params.length; i++) {
		var tky = ZDC.wgsTotky(new ZDC.LatLon(
				parseFloat(params[i].latlon.center.y),
				parseFloat(params[i].latlon.center.x)));
		icon_bus_stop[i] = new ZDC.Marker(tky, {
			/* マーカのサイズに合わせて位置を調整する */
			offset : new ZDC.Pixel(-10, -16),
			custom : {
				base : {
					src : '.././img/icon_bus_stop.png'
				}
			}
		});
		map.addWidget(icon_bus_stop[i]);

		/*
		 * マーカがクリックされたら そのマーカの緯度経度を吹き出しに表示する関数を実行させる
		 */
		ZDC.bind(icon_bus_stop[i], ZDC.MARKER_MOUSEUP, {
			name : params[i].busStopName,
			latlon : tky,
			info : msg_bus_stop
		}, showInfoMsgBusStand);
	}
};

/**
 * バス停の吹き出しを表示する
 */
function showInfoMsgBusStand() {
	this.info.moveLatLon(this.latlon);
	this.info.setHtml('<div style="font-size:80%; line-height: 1.3;"><b>'
			+ this.name + '</b><br>' + '</div>');
	this.info.open();
};

/**
 * 複数の座標が全て地図に収まるように縮尺、座標を変更する
 */
function setZoomAndLatlon(params) {
	var latlons = [];
	for (i = 0; i < params.length; i++) {
		latlons[i] = ZDC.wgsTotky(new ZDC.LatLon(params[i].latlon.center.y,
				params[i].latlon.center.x));
	}
	var adjust = map.getAdjustZoom(latlons);
	map.moveLatLon(adjust.latlon);
	map.setZoom(adjust.zoom);
};

/**
 * 路線図のルートをセットする
 *
 * @param params
 *            BusRouteLatlonList
 */
function setBusRoute(params) {
	var latlons = [];
	for (var i = 0; i < params.length; i++) {
		latlons.push(ZDC.wgsTotky(new ZDC.LatLon(params[i].latlon.center.y,
				params[i].latlon.center.x)));
	}
	/* 線を作成 */
	bus_route = new ZDC.Polyline(latlons, {
		strokeWeight : 5,
		strokeColor : '#008800',
		lineOpacity : 0.5,
	});
	/* 線を地図に追加 */
	map.addWidget(bus_route);
}

/**
 * マップの緯度経度、ズームを初期化する
 */
function viewAllBusMap() {
	var lat = 42.828261389, lon = 141.652161111;
	var latlon = new ZDC.LatLon(lat, lon);
	var tky = ZDC.wgsTotky(latlon);
	map.moveLatLon(tky);
	map.setZoom(0);
}

/**
 * バスアイコン削除
 */
function removeIconBus() {
	if (icon_bus) {
		for (var i = 0; i < icon_bus.length; i++) {
			map.removeWidget(icon_bus[i]);
		}
	}
};

/**
 * バス吹き出し削除
 */
function removeMsgBus() {
	if (msg_bus) {
		map.removeWidget(msg_bus);
	}
}

/**
 * バス停削除
 */
function removeBusStand() {
	if (icon_bus_stop) {
		for (var i = 0; i < icon_bus_stop.length; i++) {
			map.removeWidget(icon_bus_stop[i]);
		}
	}
}

/**
 * バス停吹き出し削除
 */
function removeMsgStand() {
	if (msg_bus_stop) {
		map.removeWidget(msg_bus_stop);
	}
}

/**
 * バスルート削除
 */
function removeBusRoute() {
	if (bus_route)
		map.removeWidget(bus_route);
}

/**
 * バスアイコン、バス吹き出し、バス停アイコン、バス停吹き出し、バスルートを削除する
 */
function removeAllWidget() {
	removeIconBus();
	removeMsgBus();
	removeBusStand();
	removeMsgStand();
	removeBusRoute();
}
