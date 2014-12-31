/**
 * Created by Robert on 2014-12-31.
 */
function JSONParametersConverter() {
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

JSONParametersConverter.prototype.getJSON = function () {
    var UIhelper = new UIHelper();

    this.source = UIhelper.getTextFromSelect($("#sourceSelect")[0]);
    this.tagType = UIhelper.getTextFromSelect($("#tagSelect")[0]);

    this.minVotesAmount = UIhelper.getValueFromSlider($("#minVotesNumSlider"));
    this.maxVotesAmount = UIhelper.getValueFromSlider($("#maxVotesNumSlider"));

    this.minViewsAmount = UIhelper.getValueFromSlider($("#minViewsNumSlider"));
    this.maxViewsAmount = UIhelper.getValueFromSlider($("#maxViewsNumSlider"));

    this.minCommentsAmount = UIhelper.getValueFromSlider($("#minCommentsNumSlider"));
    this.maxCommentsAmount = UIhelper.getValueFromSlider($("#maxCommentsNumSlider"));

    this.minCreatedTime = UIhelper.getValueFromDatePicker($("#minCreatedTime"));
    this.maxCreatedTime = UIhelper.getValueFromDatePicker($("#maxCreatedTime"));

    return JSON.stringify(this);
};