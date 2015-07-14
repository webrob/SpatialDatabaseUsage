/**
 * Created by Robert on 2014-12-28.
 */
$(document).ready(function () {
    getInitData();
    $("#tabsMenu").tabs();
});

function getInitData() {
    var url = "SpatialDatabaseUsage/init";
    $.getJSON(url, function (result) {
        initAllControlWithData(result[0]);
    });
}

function initAllControlWithData(initData) {
    var minVotesNumSlider = $("#minVotesNumSlider");
    var minVotesNumLabel = $("#minVotesNumLabel");

    var maxVotesNumSlider = $("#maxVotesNumSlider");
    var maxVotesNumLabel = $("#maxVotesNumLabel");

    initSlider(minVotesNumSlider, minVotesNumLabel, 0, initData.votesAmount);
    initSlider(maxVotesNumSlider, maxVotesNumLabel, initData.votesAmount, initData.votesAmount);

    minVotesNumSlider.on("slidechange", function (event, ui) {
        var newValue = ui.value;
        minVotesNumLabel.html(newValue);
        if (newValue > getSliderValue(maxVotesNumSlider)) {
            setSliderValue(maxVotesNumSlider, newValue);
        }
    });

    maxVotesNumSlider.on("slidechange", function (event, ui) {
        var newValue = ui.value;
        maxVotesNumLabel.html(newValue);
        if (newValue < getSliderValue(minVotesNumSlider)) {
            setSliderValue(minVotesNumSlider, newValue);
        }
    });


    var minViewsNumSlider = $("#minViewsNumSlider");
    var minViewsNumLabel = $("#minViewsNumLabel");

    var maxViewsNumSlider = $("#maxViewsNumSlider");
    var maxViewsNumLabel = $("#maxViewsNumLabel");

    initSlider(minViewsNumSlider, minViewsNumLabel, 0, initData.viewsAmount);
    initSlider(maxViewsNumSlider, maxViewsNumLabel, initData.viewsAmount, initData.viewsAmount);

    minViewsNumSlider.on("slidechange", function (event, ui) {
        var newValue = ui.value;
        minViewsNumLabel.html(newValue);
        if (newValue > getSliderValue(maxViewsNumSlider)) {
            setSliderValue(maxViewsNumSlider, newValue);
        }
    });

    maxViewsNumSlider.on("slidechange", function (event, ui) {
        var newValue = ui.value;
        maxViewsNumLabel.html(newValue);
        if (newValue < getSliderValue(minViewsNumSlider)) {
            setSliderValue(minViewsNumSlider, newValue);
        }
    });


    var minCommentsNumSlider = $("#minCommentsNumSlider");
    var minCommentsNumLabel = $("#minCommentsNumLabel");

    var maxCommentsNumSlider = $("#maxCommentsNumSlider");
    var maxCommentsNumLabel = $("#maxCommentsNumLabel");

    initSlider(minCommentsNumSlider, minCommentsNumLabel, 0, initData.commentsAmount);
    initSlider(maxCommentsNumSlider, maxCommentsNumLabel, initData.commentsAmount, initData.commentsAmount);

    minCommentsNumSlider.on("slidechange", function (event, ui) {
        var newValue = ui.value;
        minCommentsNumLabel.html(newValue);
        if (newValue > getSliderValue(maxCommentsNumSlider)) {
            setSliderValue(maxCommentsNumSlider, newValue);
        }
    });

    maxCommentsNumSlider.on("slidechange", function (event, ui) {
        var newValue = ui.value;
        maxCommentsNumLabel.html(newValue);
        if (newValue < getSliderValue(minCommentsNumSlider)) {
            setSliderValue(minCommentsNumSlider, newValue);
        }
    });

    var minCreatedTime = $("#minCreatedTime");
    initDatePicker(minCreatedTime, initData.minCreatedTime, initData.minCreatedTime, initData.maxCreatedTime);

    var maxCreatedTime = $("#maxCreatedTime");
    initDatePicker(maxCreatedTime, initData.maxCreatedTime, initData.minCreatedTime, initData.maxCreatedTime);
    setInitDataForSelect($('#sourceSelect'), initData.sources);
    setInitDataForSelect($('#tagSelect'), initData.tagTypes);
    setInitDataForSelect($('#citySelect'), initData.cites);
}

function initDatePicker(datePicker, date, minData, maxDate) {
    datePicker.datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'yy-mm-dd',
        minDate: minData,
        maxDate: maxDate
    });
    datePicker.datepicker("setDate", date);
}

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

function searchClickedOnParametersTab() {
    spatialMarkerManager.clearMarkersFromMapAndMemory();

    switch ($("#citySelect")[0].selectedIndex) {
        case 0:
        {
            spatialMarkerManager.setChicagoCenter();
            break;
        }
        case 1:
        {
            spatialMarkerManager.setNewHavenCenter();
            break;
        }
        case 2:
        {
            spatialMarkerManager.setOaklandCenter();
            break;
        }
        case 3:
        {
            spatialMarkerManager.setRichmondCenter();
            break;
        }
    }

    var jsonParameters = new JSONParametersConverter();

    var json = jsonParameters.getJSON();
    var url = "SpatialDatabaseUsage/issues?parameters=";
    var encodedURL = url + encodeURIComponent(json);
    $.getJSON(encodedURL, function (result) {
        spatialMarkerManager.clearMarkersFromMapAndMemory();
        $.each(result, function (i, field) {
            spatialMarkerManager.addMarkerWithInfo(field);
        });
        spatialMarkerManager.addMarkersToMap();
        $('#markersNumber').html(spatialMarkerManager.getMarkersNumber());
    });
}


function setInitDataForSelect(select, initData) {
    $.each(initData, function (i, item) {
        select.append($('<option>', {
            value: i,
            text: item
        }));
    });
}

function searchClickedOnAreaTab() {
    var jsonArea = new JSONAreaConverter();
    var json = jsonArea.getJSON();
    var url = "SpatialDatabaseUsage/issues/area?parameters=";
    var encodedURL = url + encodeURIComponent(json);
    $.getJSON(encodedURL, function (result) {
        changeAllTableData(result[0]);
    });

}


function searchClickedOnSchoolsTab() {

    var schoolTable = $('#schoolTable');
    schoolTable.find('> tbody').html("");
    schoolTable.find('> thead').html("");

    var jsonSchool = new JSONSchoolConverter();
    var json = jsonSchool.getJSON();
    var url = "SpatialDatabaseUsage/issues/school?parameters=";
    var encodedURL = url + encodeURIComponent(json);


    $.getJSON(encodedURL, function (result) {
        $.each(result, function (i, field) {
            var body = $("#schoolTable").find('tbody');
            addRowToTableBody(body, field)
        });

        var head = $('#schoolTable').find('thead');
        var row = $('<tr>');
        head.append(row);
        row.append(($('<td>')).text("name"))
            .append(($('<td>')).text("lowest class"))
            .append(($('<td>')).text("classes amount"));

    });
}

function addRowToTableBody(body, data) {
    var row = $('<tr>');
    body.append(row);
    row.append(($('<td>')).text(data.name))
        .append(($('<td>')).text(data.lowestClassType))
        .append(($('<td>')).text(data.classesAmount));
}

function changeAllTableData(data) {
    var maxHeader = $('#max');
    setDataToTableCell(maxHeader, 0, data.maxVotesAmount);
    setDataToTableCell(maxHeader, 1, data.maxCommentsAmount);
    setDataToTableCell(maxHeader, 2, data.maxViewsAmount);

    var sumHeader = $('#sum');
    setDataToTableCell(sumHeader, 0, data.sumVotesAmount);
    setDataToTableCell(sumHeader, 1, data.sumCommentsAmount);
    setDataToTableCell(sumHeader, 2, data.sumViewsAmount);

    var avgHeader = $('#avg');
    setDataToTableCell(avgHeader, 0, data.avgVotesAmount);
    setDataToTableCell(avgHeader, 1, data.avgCommentsAmount);
    setDataToTableCell(avgHeader, 2, data.avgViewsAmount);

    $('#pointsNumber').html(data.pointsAmount);
}

function setDataToTableCell(tableHeader, rowNumber, data) {
    tableHeader.find('td').eq(rowNumber).html(data);
}


function initSlider(slider, label, value, max) {
    slider.slider({
        value: value,
        min: 0,
        max: max,
        step: 1
    });
    label.html(getSliderValue(slider));
}

function areaTabClicked() {
    spatialMarkerManager.showAreaDrawingManger();
}

function parametersTabClicked() {
    spatialMarkerManager.disableDrawingMode();
}

function schoolTabClicked() {
    spatialMarkerManager.showSchoolDrawingManager();
}

function getSliderValue(slider) {
    return slider.slider("value")
}

function setSliderValue(slider, value) {
    slider.slider('value', value);
}