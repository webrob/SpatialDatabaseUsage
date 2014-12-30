/**
 * Created by Robert on 2014-12-28.
 */


$(document).ready(function () {
    $("#searchData").click(function () {
        markerCluster.clearMarkers();
        markers = [];
        $.getJSON("http://localhost:9999/SpatialDatabaseUsage/SpatialDatabaseUsage/users", function (result) {
            $.each(result, function (i, field) {
                var marker = addMarker(field.latitude, field.longitude);
                addInfoToMarker(marker, field.tagType, field.description, field.votesAmount, field.commentsAmount, field.viewsAmount);
            });
            markerCluster.addMarkers(markers);
        });
    });

    $(function () {
        $("#Tabs1").tabs();
    });


    $('input[id=lefile]').change(function () {
        $('#photoCover').val($(this).val());
    });
});