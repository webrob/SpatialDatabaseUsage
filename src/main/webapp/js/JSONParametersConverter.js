/**
 * Created by Robert on 2014-12-31.
 */
function JSONParametersConverter() {

    this.sourceSelected = null;
    this.tagTypeSelected = null;
    this.createdTimeSelected = null;
    this.voteAmountSelected = null;
    this.commentsAmountSelected = null;
    this.viewsAmountSelected = null;

    this.source = null;
    this.tagType = null;
    this.city = null;

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
    var uiHelper = new UIHelper();

    this.sourceSelected = uiHelper.getValueFromCheckbox($("#sourceCheckbox"));
    this.tagTypeSelected = uiHelper.getValueFromCheckbox($("#tagCheckbox"));
    this.createdTimeSelected = uiHelper.getValueFromCheckbox($("#createdTimeCheckbox"));
    this.voteAmountSelected = uiHelper.getValueFromCheckbox($("#votesNumCheckbox"));
    this.viewsAmountSelected = uiHelper.getValueFromCheckbox($("#viewsNumCheckbox"));
    this.commentsAmountSelected = uiHelper.getValueFromCheckbox($("#commentsNumCheckbox"));


    this.source = uiHelper.getTextFromSelect($("#sourceSelect")[0]);
    this.tagType = uiHelper.getTextFromSelect($("#tagSelect")[0]);
    this.city = uiHelper.getTextFromSelect($("#citySelect")[0]);

    this.minVotesAmount = uiHelper.getValueFromSlider($("#minVotesNumSlider"));
    this.maxVotesAmount = uiHelper.getValueFromSlider($("#maxVotesNumSlider"));

    this.minViewsAmount = uiHelper.getValueFromSlider($("#minViewsNumSlider"));
    this.maxViewsAmount = uiHelper.getValueFromSlider($("#maxViewsNumSlider"));

    this.minCommentsAmount = uiHelper.getValueFromSlider($("#minCommentsNumSlider"));
    this.maxCommentsAmount = uiHelper.getValueFromSlider($("#maxCommentsNumSlider"));

    this.minCreatedTime = uiHelper.getValueFromDatePicker($("#minCreatedTime"));
    this.maxCreatedTime = uiHelper.getValueFromDatePicker($("#maxCreatedTime"));

    return JSON.stringify(this);
};