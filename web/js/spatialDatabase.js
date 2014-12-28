/**
 * Created by Robert on 2014-12-28.
 */
$(document).ready(function () {
    $("#getData").click(function () {
        $("#myDiv").append("ee ");
        $.getJSON("http://localhost:9999/SpatialDatabaseUsage/SpatialDatabaseUsage/users", function (result) {
            $.each(result, function (i, field) {
                $("#myDiv").append(field.firstName + "\n");
            });
        });
    });
});