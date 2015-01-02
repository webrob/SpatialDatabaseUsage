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

Number.prototype.toRad = function() {
    return this * Math.PI / 180;
};

Number.prototype.toDeg = function() {
    return this * 180 / Math.PI;
};

google.maps.LatLng.prototype.destinationPoint = function(brng, dist) {
    dist = dist / 6371 / 1000;
    brng = brng.toRad();

    var lat1 = this.lat().toRad(), lon1 = this.lng().toRad();

    var lat2 = Math.asin(Math.sin(lat1) * Math.cos(dist) +
    Math.cos(lat1) * Math.sin(dist) * Math.cos(brng));

    var lon2 = lon1 + Math.atan2(Math.sin(brng) * Math.sin(dist) *
            Math.cos(lat1),
            Math.cos(dist) - Math.sin(lat1) *
            Math.sin(lat2));

    if (isNaN(lat2) || isNaN(lon2)) return null;

    return new google.maps.LatLng(lat2.toDeg(), lon2.toDeg());
};

var spatialMarkerManager;

function initialize() {
    spatialMarkerManager = new SpatialMarkerManager();
    spatialMarkerManager.initAll();
}

google.maps.event.addDomListener(window, 'load', initialize);


