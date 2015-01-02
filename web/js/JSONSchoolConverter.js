/**
 * Created by Robert on 2015-01-02.
 */

function JSONSchoolConverter() {
    this.distance = null;
    this.latitude = null;
    this.longitude = null;

    this.getJSON = function () {
        this.distance = spatialMarkerManager.getCircleRadiusInGeoCoordinates();

        var center = spatialMarkerManager.getCircleCenter();

        this.latitude = center.lat();
        this.longitude = center.lng();

        return JSON.stringify(this);
    }
}