/**
 * Created by Robert on 2014-12-31.
 */
function SpatialMarkerManager() {
    this.gm = google.maps;
    this.chicago = new google.maps.LatLng(41.850033, -87.6500523);
    this.newHaven = new google.maps.LatLng(41.309970, -72.928786);
    this.richmond = new google.maps.LatLng(37.540239, -77.436284);
    this.oakland = new google.maps.LatLng(37.804169, -122.279606);
    this.map = null;
    this.markerCluster = null;
    this.markers = [];
    this.drawingManager = null;
    this.shape = null;
    this.infoWindow = new this.gm.InfoWindow({maxWidth: 250});
    this.oms = null;
    this.contentString =
        '<div id="content">' +
        '<div id="siteNotice">' +
        '</div>' +
        '<h1 id="firstHeading" class="firstHeading">Details</h1>' +
        '<div id="bodyContent">' +
        '<p><b>tag: </b> {0}</p>' +
        '<p><b>description: </b> {1}</p>' +
        '<table class="table" >' +
        '<tr> ' +
        '<th>num votes</th>' +
        '<th>num comments</th>' +
        '<th>num views</th> ' +
        '</tr>' +
        '<tr>' +
        '<td>{2}</td> ' +
        '<td>{3}</td> ' +
        '<td>{4}</td> ' +
        '</tr> ' +
        '</table>' +
        '<p><b>source: </b> {5}</p>' +
        '<p><b>created time: </b> {6}</p>' +
        '</div>' +
        '</div>';

    this.initAll = function () {
        this.initMap();
        this.initAreaDrawingManager();
        this.initMarkerCluster();

        var legend = document.getElementById('legend');
        this.map.controls[google.maps.ControlPosition.RIGHT_TOP].push(legend);
    };

    this.initMap = function () {
        this.map = new google.maps.Map(document.getElementById('map-canvas'), {
            zoom: 10,
            center: this.chicago,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        });

        this.oms = new OverlappingMarkerSpiderfier(this.map,
            {markersWontMove: true, markersWontHide: true});

        var _this = this;
        this.oms.addListener('click', function (marker) {
            _this.infoWindow.setContent(marker.desc);
            _this.infoWindow.open(_this.map, marker);
        });

        this.oms.addListener('spiderfy', function (markers) {
            _this.infoWindow.close();
        });

    };


    this.getMarkersNumber = function () {
        return this.markers.length;
    };


    this.clearMarkersFromMapAndMemory = function () {
        this.markerCluster.clearMarkers();
        this.markers = [];
    };

    this.addMarkersToMap = function () {
        this.markerCluster.addMarkers(this.markers);
    };

    this.addMarkerWithInfo = function (issue) {
        var marker = this.addMarker(issue.latitude, issue.longitude);
        marker.desc = this.contentString.format(issue.tagType, issue.description, issue.votesAmount, issue.commentsAmount, issue.viewsAmount, issue.source, issue.createdTime);
        this.oms.addMarker(marker);
    };

    this.addMarker = function (lat, lng) {
        var latLng = new google.maps.LatLng(lat, lng);
        var marker = new google.maps.Marker({
            position: latLng
        });
        this.markers.push(marker);
        return marker;
    };

    this.initAreaDrawingManager = function () {
        this.drawingManager = new google.maps.drawing.DrawingManager({
            drawingControl: true,
            drawingControlOptions: {
                position: google.maps.ControlPosition.TOP_RIGHT,
                drawingModes: []
            },
            rectangleOptions: {
                zIndex: 1,
                editable: true,
                draggable: true
            },
            circleOptions: {
                zIndex: 1,
                editable: true,
                draggable: true
            }
        });

        var _this = this;
        google.maps.event.addListener(this.drawingManager, "overlaycomplete", function (event) {
            if (_this.shape != null) {
                _this.shape.setMap(null);
            }
            _this.shape = event.overlay;
        });

        this.drawingManager.setMap(this.map);
    };


    this.hideShape = function () {
        if (this.shape != null) {
            this.shape.setMap(null);
            this.shape = null;
        }
    };

    this.disableDrawingMode = function () {
        this.hideShape();
        this.drawingManager.setOptions({
            drawingControlOptions: {
                position: google.maps.ControlPosition.TOP_RIGHT,
                drawingModes: []
            }
        });
        this.drawingManager.setDrawingMode(null);
    };

    this.showAreaDrawingManger = function () {
        this.hideShape();
        this.drawingManager.setOptions({
            drawingMode: google.maps.drawing.OverlayType.RECTANGLE,
            drawingControlOptions: {
                position: google.maps.ControlPosition.TOP_RIGHT,
                drawingModes: [google.maps.drawing.OverlayType.RECTANGLE]
            }
        });
    };

    this.showSchoolDrawingManager = function () {
        this.hideShape();
        this.drawingManager.setOptions({
            drawingMode: google.maps.drawing.OverlayType.CIRCLE,
            drawingControlOptions: {
                position: google.maps.ControlPosition.TOP_RIGHT,
                drawingModes: [google.maps.drawing.OverlayType.CIRCLE]
            }
        });
    };


    this.initMarkerCluster = function () {
        this.markerCluster = new MarkerClusterer(this.map, [], {maxZoom: 19});
    };

    this.getRectangleBounds = function () {
        var bounds = null;
        if (this.shape != null) {
            bounds = this.shape.getBounds();
        }
        return bounds;
    };

    this.getCircleRadiusInGeoCoordinates = function() {
        var distance = 0;
        if (this.shape != null) {
            var bounds = this.shape.getBounds();
            var ne = bounds.getNorthEast();
            var sw = bounds.getSouthWest();

            distance = (ne.lng() - sw.lng()) /2.0;
        }
        return distance;
    };

    this.getCircleCenter = function() {
        var center;
        if (this.shape != null) {
            center = this.shape.getCenter();
        }
        return center;
    };

    this.setChicagoCenter = function () {
        this.map.setCenter(this.chicago);
    };

    this.setRichmondCenter = function () {
        this.map.setCenter(this.richmond);
    };

    this.setNewHavenCenter = function () {
        this.map.setCenter(this.newHaven);
    };

    this.setOaklandCenter = function () {
        this.map.setCenter(this.oakland);
    };

}

