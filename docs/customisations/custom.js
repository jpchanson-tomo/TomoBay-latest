////////////////////////////////////////////////////////////////////////////////////////////////MAIN
/**
 * performs all functions that need to be carried out when dealing with custom pages
 */
$(document).ready(function()
{
	resizeContentIframes();
});
//////////////////////////////////////////////////////////////////////////////////////////ENDOF MAIN

////////////////////////////////////////////////////////////////////////////////////CUSTOM FUNCTIONS
/**
 * resizes the dynamic content iframes so that it is roughly but no larger than the doxygen content
 * pane.
 */
function resizeContentIframes()
{
	var height = $('.navpath').offset().top - ($('.header').offset().top + $('.header').outerHeight(true));
	height = height - 40;
	$(".iframe-full-height").css("height", height);
}

//////////////////////////////////////////////////////////////////////////////ENDOF CUSTOM FUNCTIONS

