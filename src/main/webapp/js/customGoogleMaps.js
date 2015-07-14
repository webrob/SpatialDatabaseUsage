if (!String.prototype.format) {
    String.prototype.format = function () {
        var args = arguments;
        return this.replace(/{(\d+)}/g, function (match, number) {
            return typeof args[number] != 'undefined'
                ? args[number]
                : match;
        });
    };
}

var spatialMarkerManager;
function initialize() {
    spatialMarkerManager = new SpatialMarkerManager();
    spatialMarkerManager.initAll();
}

google.maps.event.addDomListener(window, 'load', initialize);


