/**
 * Created by Robert on 2014-12-28.
 */


$(document).ready(function () {
    $("#searchData").click(function () {
        spatialMarkerManager.clearMarkersFromMapAndMemory();
        $.getJSON("http://localhost:9999/SpatialDatabaseUsage/SpatialDatabaseUsage/users", function (result) {
            $.each(result, function (i, field) {
            spatialMarkerManager.addMarkerWithInfo(field);
            });
            spatialMarkerManager.addMarkersToMap();
        });
    });

    $(function () {
        $("#Tabs1").tabs();
    });


    $('input[id=lefile]').change(function () {
        $('#photoCover').val($(this).val());
    });
});

function areaTabClicked() {
    spatialMarkerManager.showDrawingManger();
}

function nonAreaTabClicked() {
    spatialMarkerManager.hideDrawingManager();
}