//AccuratePosition
//時間の許す限り正確な位置情報を取得する
function getAccuratePosition() {
    // 位置情報に対応していなければ終了
    if (!navigator.geolocation) {
        var error = new Object();
        error.code = 1;
        errorCallback(error);
        return;
    }

    // 変数の初期化
    var watchOperationId; // 位置情報取得実行時の一回一回の処理のID
    var timerOperationId; // タイマーのID
    var position; // 現在位置を管理するオブジェクト
    // var accuracyLimit = 30; // 位置情報取得精度の誤差の最大値
    var accuracyLimit = 50;
    var lat = 0;
    var lon = 0;
    var accuracy = 0;

    // タイムアウトを設定
    timerOperationId = setTimeout(function () {
        // 位置情報の取得を中止する
        if (watchOperationId) {
            navigator.geolocation.clearWatch(watchOperationId);
            watchOperationId = undefined;
        }

        // 位置情報を一度も取得できなかった場合
        if (!position) {
            var error = new Object();
            error.code = 2;
            errorCallback(error);
            return;
        }
    }, 10000);

    // 取得を実行
    watchOperationId = navigator.geolocation.watchPosition(function (currentPosition) {
        // 取得のたびに更新する
        position = currentPosition;
        lat = position.coords.latitude;
        lon = position.coords.longitude;
        accuracy = position.coords.accuracy;

        var elem = document.getElementById("log");
        elem.innerHTML = "lat:" + lat + ", lon:" + lon + ", 精度:" + accuracy;

        // 求める精度に達すればsuccessCallbackに送る
        if (accuracy <= accuracyLimit) {
            // タイムアウト監視を止める
            if (timerOperationId) {
                clearTimeout(timerOperationId);
                // timerOperationId = undefined;
            }
            navigator.geolocation.clearWatch(watchOperationId);
            sendPosition(lat, lon);
        }
    }, function (error) {
        errorCallback(error);
    }, {
        enableHighAccuracy: true,
        maximumAge: 0
    });
}
// 取得を実行
function sendPosition(lat, lon) {
    console.log("onGeoSuccess");

    document.getElementById("Latitude").value = lat;
    document.getElementById("Longitude").value = lon;

    var ajaxButton = document.getElementById("aButton");
    var event = document.createEvent("MouseEvents");
    // event.initMouseEvent("click", false, true, window, 0, 0, 0, 0, 0, false,
    // 		false, false, false, 0, null);
    event.initEvent("click", false, false);
    ajaxButton.dispatchEvent(event);
}

function errorCallback(error) {
    var errorMessage = "";
    switch (error.code) {
        case 1:
            errorMessage = "Geolocation APIが利用できません";
            break;
        case 2:
            errorMessage = "10000[ms]が経過しても位置情報を取得できませんでした";
            break;
    }
    console.log("error : " + error.message + '(' + error.code + ')');
}

function setLatlon() {
    console.log("setLatlon");
    getAccuratePosition();
}
