/**
 * Created by Robert on 2014-12-28.
 */


$(document).ready(function () {

    $("#searchData").click(function () {
        var jsonHelper = new JSONConverter();
        var json = jsonHelper.getJSON();

        spatialMarkerManager.clearMarkersFromMapAndMemory();
        var url = "http://localhost:9999/SpatialDatabaseUsage/SpatialDatabaseUsage/issues?parameters=";
        var encodedURL = url + encodeURIComponent(json);
        $.getJSON(encodedURL, function (result) {
            spatialMarkerManager.clearMarkersFromMapAndMemory();
            $.each(result, function (i, field) {
                spatialMarkerManager.addMarkerWithInfo(field);
            });
            spatialMarkerManager.addMarkersToMap();
        });
    });

    $("#Tabs1").tabs();
    initSlider($("#minVotesNumSlider"), $("#minVotesNumLabel"));
    initSlider($("#maxVotesNumSlider"), $("#maxVotesNumLabel"));

    initSlider($("#minViewsNumSlider"), $("#minViewsNumLabel"));
    initSlider($("#maxViewsNumSlider"), $("#maxViewsNumLabel"));

    initSlider($("#minCommentsNumSlider"), $("#minCommentsNumLabel"));
    initSlider($("#maxCommentsNumSlider"), $("#maxCommentsNumLabel"));

    var minCreatedTime = $("#minCreatedTime");
    minCreatedTime.datepicker({changeMonth: true, changeYear: true});
    minCreatedTime.datepicker( "setDate" , "7/11/2011" );

    var maxCreatedTime  = $("#maxCreatedTime");
    maxCreatedTime.datepicker({changeMonth: true, changeYear: true});
    maxCreatedTime.datepicker( "setDate" , "7/11/2011" );
});


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

function JSONConverter() {
    this.source = null;
    this.tagType = null;

    this.minVotesAmount = null;
    this.minCommentsAmount = null;
    this.minViewsAmount = null;
    this.minCreatedTime = null;

    this.maxVotesAmount = null;
    this.maxCommentsAmount = null;
    this.maxViewsAmount = null;
    this.maxCreatedTime = null;
}

JSONConverter.prototype.getJSON = function () {
    this.source = this.getTextFromSelect($("#sourceSelect")[0]);
    this.tagType = this.getTextFromSelect($("#tagSelect")[0]);

    this.minVotesAmount = this.getValueFromSlider($("#minVotesNumSlider"));
    this.maxVotesAmount = this.getValueFromSlider($("#maxVotesNumSlider"));

    this.minViewsAmount = this.getValueFromSlider($("#minViewsNumSlider"));
    this.maxViewsAmount = this.getValueFromSlider($("#maxViewsNumSlider"));

    this.minCommentsAmount = this.getValueFromSlider($("#minCommentsNumSlider"));
    this.maxCommentsAmount = this.getValueFromSlider($("#maxCommentsNumSlider"));

    this.minCreatedTime = this.getValueFromDatePicker($("#minCreatedTime"));
    this.maxCreatedTime = this.getValueFromDatePicker($("#maxCreatedTime"));

    return JSON.stringify(this);
};

JSONConverter.prototype.getTextFromSelect = function (selectedSelect) {
    var selectedIndex = selectedSelect.selectedIndex;
    return selectedSelect.options[selectedIndex].text;
};

JSONConverter.prototype.getValueFromSlider = function (slider) {
    return slider.slider("value");
};

JSONConverter.prototype.getValueFromDatePicker = function (datePicker) {
    return datePicker.val();
};

