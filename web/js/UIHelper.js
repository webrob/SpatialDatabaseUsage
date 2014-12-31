/**
 * Created by Robert on 2014-12-31.
 */

function UIHelper()
{
    this.getTextFromSelect = function (selectedSelect) {
        var selectedIndex = selectedSelect.selectedIndex;
        return selectedSelect.options[selectedIndex].text;
    };

    this.getValueFromSlider = function (slider) {
        return slider.slider("value");
    };

    this.getValueFromDatePicker = function (datePicker) {
        return datePicker.val();
    };
}

