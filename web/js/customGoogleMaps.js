var map;
var chicago = new google.maps.LatLng(41.850033, -87.6500523);


var markerCluster;
var markers = [];
var drawingManager;
function addMarker(lat, lng) {
    var latlng = new google.maps.LatLng(lat, lng);
    var marker = new google.maps.Marker({
        position: latlng
    });
    markers.push(marker);
    return marker;
}

var contentString = '<div id="content">' +
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
    '</div>' +
    '</div>';

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
function addInfoToMarker(marker, tagType, description, numVotes, numComments, numViews) {

    var infowindow = new google.maps.InfoWindow({
        content: contentString.format(tagType, description, numVotes, numComments, numViews),
        maxWidth: 200
    });

    google.maps.event.addListener(marker, 'click', function () {
        infowindow.open(map, marker);
    });
}

var rectangle;

function initialize() {
    map = new google.maps.Map(document.getElementById('map-canvas'), {
        zoom: 10,
        center: chicago,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    drawingManager = new google.maps.drawing.DrawingManager({
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


    google.maps.event.addListener(drawingManager, "overlaycomplete", function(event){
        if (rectangle != null)
        {
            rectangle.setMap(null);
        }
        rectangle = event.overlay;
    });


    drawingManager.setMap(map);
    markerCluster = new MarkerClusterer(map);

    var legend = document.getElementById('legend');

    map.controls[google.maps.ControlPosition.RIGHT_TOP].push(legend);

}

google.maps.event.addDomListener(window, 'load', initialize);

function showNewRect(event) {
    var ne = rectangle.getBounds().getNorthEast();
    var sw = rectangle.getBounds().getSouthWest();
}





function areaTabClicked()
{
    drawingManager.setOptions({
        drawingControl: true
    });
}

function nonAreaTabClicked()
{
    if (rectangle != null)
    {
        rectangle.setMap(null);
        rectangle = null;
    }
    drawingManager.setOptions({
        drawingControl: false
    });
}