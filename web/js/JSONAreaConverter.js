/**
 * Created by Robert on 2014-12-31.
 */
function JSONAreaConverter() {
    this.nortEastLatitude = null;
    this.nortEastLongitude = null;
    this.southWestLatitude = null;
    this.southWestLongitude = null;

    this.getJSON = function () {
        var bounds = spatialMarkerManager.getRectangleBounds();
        if (bounds != null) {
            var ne = bounds.getNorthEast();
            var sw = bounds.getSouthWest();

            this.nortEastLatitude = ne.lat();
            this.nortEastLongitude = ne.lng();

            this.southWestLatitude = sw.lat();
            this.southWestLongitude = sw.lng();
        }
        return JSON.stringify(this);
    }
}


