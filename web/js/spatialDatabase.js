/**
 * Created by Robert on 2014-12-28.
 */


$(document).ready(function () {
    $("#tabsMenu").tabs();
    initSlider($("#minVotesNumSlider"), $("#minVotesNumLabel"));
    initSlider($("#maxVotesNumSlider"), $("#maxVotesNumLabel"));

    initSlider($("#minViewsNumSlider"), $("#minViewsNumLabel"));
    initSlider($("#maxViewsNumSlider"), $("#maxViewsNumLabel"));

    initSlider($("#minCommentsNumSlider"), $("#minCommentsNumLabel"));
    initSlider($("#maxCommentsNumSlider"), $("#maxCommentsNumLabel"));

    var minCreatedTime = $("#minCreatedTime");
    minCreatedTime.datepicker({changeMonth: true, changeYear: true});
    minCreatedTime.datepicker("setDate", "7/11/2011");

    var maxCreatedTime = $("#maxCreatedTime");
    maxCreatedTime.datepicker({changeMonth: true, changeYear: true});
    maxCreatedTime.datepicker("setDate", "7/11/2011");
});

function searchClicked() {
    var index = $("#tabsMenu").tabs('option', 'active');
    switch (index) {
        case 0:
        {
            searchClickedOnParametersTab();
            break;
        }
        case 1:
        {
            searchClickedOnAreaTab();
            break;
        }
        case 2:
        {
            searchClickedOnSchoolsTab();
            break;
        }
    }


}

function searchClickedOnParametersTab()
{
    spatialMarkerManager.clearMarkersFromMapAndMemory();
    var jsonParameters = new JSONParametersConverter();

    var json = jsonParameters.getJSON();
    var url = "http://localhost:9999/SpatialDatabaseUsage/SpatialDatabaseUsage/issues?parameters=";
    var encodedURL = url + encodeURIComponent(json);
    $.getJSON(encodedURL, function (result) {
        spatialMarkerManager.clearMarkersFromMapAndMemory();
        $.each(result, function (i, field) {
            spatialMarkerManager.addMarkerWithInfo(field);
        });
        spatialMarkerManager.addMarkersToMap();
    });
}

function searchClickedOnAreaTab()
{
    var jsonArea = new JSONAreaConverter();
    var json = jsonArea.getJSON();
    var url = "http://localhost:9999/SpatialDatabaseUsage/SpatialDatabaseUsage/issues/area?parameters=";
    var encodedURL = url + encodeURIComponent(json);
    $.getJSON(encodedURL, function (result) {

    });

}

function searchClickedOnSchoolsTab()
{

}


function initSlider(slider, label) {
    slider.slider({
        value: 0,
        min: 0,
        max: 150,
        step: 3,
        slide: function (event, ui) {
            label.html(ui.value);
        }
    });
    label.html(slider.slider("value"));
}

function areaTabClicked() {
    spatialMarkerManager.showDrawingManger();
}

function nonAreaTabClicked() {
    spatialMarkerManager.hideDrawingManager();
}