/**
 * Created by Robert on 2014-12-31.
 */


function SpatialMarkerManager() {
    this.gm = google.maps;
    this.chicago = new google.maps.LatLng(41.850033, -87.6500523);
    this.map = null;
    this.markerCluster = null;
    this.markers = [];
    this.drawingManager = null;
    this.rectangle = null;
    this.infoWindow = new this.gm.InfoWindow({maxWidth: 250});
    this.oms = null;
    this.contentString =
        '<div id="content">' +
        '<div id="siteNotice">' +
        '</div>' +
        '<h1 id="firstHeading" class="firstHeading">Details</h1>' +
        '<div id="bodyContent">' +
        '<p>tag - {0}</p>' +
        '<p>{1}</p>' +
        '<table class="table-bordered" >' +
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
        '<p><b>created time: </b> {5}</p>' +
        '</div>' +
        '</div>';

    this.initAll = function () {
        this.initMap();
        this.initDrawingManager();
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
        this.oms.addListener('click', function(marker) {
            _this.infoWindow.setContent(marker.desc);
            _this.infoWindow.open(_this.map, marker);
        });

        this.oms.addListener('spiderfy', function(markers) {
            _this.infoWindow.close();
        });

    };

    this.hideDrawingManager = function () {
        if (this.rectangle != null) {
            this.rectangle.setMap(null);
            this.rectangle = null;
        }
        this.drawingManager.setOptions({
            drawingControl: false
        });
        this.drawingManager.setDrawingMode(null);
    };

    this.showDrawingManger = function () {
        this.drawingManager.setOptions({
            drawingControl: true
        });
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
        marker.desc =  this.contentString.format(issue.tagType, issue.description, issue.votesAmount, issue.commentsAmount, issue.viewsAmount, issue.createdTime);
        this.oms.addMarker(marker);
        //this.addInfoToMarker(marker, issue.tagType, issue.description, issue.votesAmount, issue.commentsAmount, issue.viewsAmount);
    };

    this.addMarker = function (lat, lng) {
        var latLng = new google.maps.LatLng(lat, lng);
        var marker = new google.maps.Marker({
            position: latLng
        });
        this.markers.push(marker);
        return marker;
    };

    this.addInfoToMarker = function (marker, tagType, description, numVotes, numComments, numViews) {
        infoWindow = new google.maps.InfoWindow({
            content: this.contentString.format(tagType, description, numVotes, numComments, numViews),
            maxWidth: 200
        });
        var _this = this;
        google.maps.event.addListener(marker, 'click', function () {
            infoWindow.open(_this.map, marker);
        });

    };

    this.initDrawingManager = function () {
        this.drawingManager = new google.maps.drawing.DrawingManager({
            drawingControl: false,
            drawingControlOptions: {
                position: google.maps.ControlPosition.TOP_RIGHT,
                drawingModes: [
                    google.maps.drawing.OverlayType.RECTANGLE
                ]
            },
            rectangleOptions: {
                zIndex: 1,
                editable: true,
                draggable: true
            }
        });

        var _this = this;
        google.maps.event.addListener(this.drawingManager, "overlaycomplete", function (event) {
            if (_this.rectangle != null) {
                _this.rectangle.setMap(null);
            }
            _this.rectangle = event.overlay;
        });

        this.drawingManager.setMap(this.map);
    };

    this.initMarkerCluster = function () {
        this.markerCluster = new MarkerClusterer(this.map, [], {maxZoom: 19});
    };

    this.getRectangleBounds = function(){
        var bounds = null;
        if (this.rectangle != null)
        {
            bounds = this.rectangle.getBounds();
        }
        return bounds;
    }

}

