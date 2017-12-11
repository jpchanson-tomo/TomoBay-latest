////////////////////////////////////////////////////////////////////////////////////////IMPORTS
$("head").append("<script src='js/external/list.min.js'></script>");
$("head").append("<script src='js/modules/ajaxTable.js'></script>");
$("head").append("<script src='js/modules/print.js'></script>");
$("head").append("<script src='js/modules/invoiceOrders.js'></script>");
$("head").append("<script src='js/modules/addCommonContent.js'></script>");
$("head").append("<script src='js/modules/colourCodeByStatus.js'></script>");
//////////////////////////////////////////////////////////////////////////////////ENDOF IMPORTS

///////////////////////////////////////////////////////////////////////////////////////////MAIN
/**
 * This is the equivalent of 'main' provides the main execution for this javascript.
 * 
 * Primary functions are to perform an ajax call to the server allowing the dynamic sortable table
 * to be populated with data. (dynamic table code provided by list.js - third party, can be found in
 * /views/js/external/list.min.js)
 * 
 * this code block also defines what callbacks are to be used after the table has been generated.
 */
$(document).ready(function(){
	var resultSelector=".sortable";
	var tableColumns=["Select", "Name","Date","SalesRecNo", "Account" , "ShippingType","Details","Status"];
	var sortableColumns=["Name","Date","SalesRecNo", "Account", "ShippingType","Status"];
	var queryString="/res/?page=SALES_ORDER_PRESENTER";
	var footerContent=	"<a class='btn btn-primary' onclick='invoiceAndPrint()'>Send to Warehouse</a>"+
	"<a class='btn btn-primary' href='/sales_orders.html'>Refresh</a>"+
	"<button onclick='printScreen()' class='btn btn-primary'>Print</button>";
	var headerContent="<h2>Sales - Orders </h2>";
	ajaxTable(resultSelector, tableColumns, sortableColumns, queryString, footerContent, headerContent, ajaxCallbacks);
	selectAllPickeableItems();
	
});
/////////////////////////////////////////////////////////////////////////////////////ENDOF MAIN

//-------------------------------------------------------------------------------AJAX CALLBACKS
/**
 * functions to be executed after the completion of the AJAX call.
 */
function ajaxCallbacks()
{
	colourCode("Pickeable","Unpickeable", "Partial",".Status");
	selectAllPickeableItems();
	itemCount();
	addSelectAllButton();
}
//-------------------------------------------------------------------------ENDOF AJAX CALLBACKS

//-------------------------------------------------------------------SELECT ALL PICKEABLE ITEMS
/**
 * automatically checks the checkboxes associated with table items that have a status of Pickeable
 */
function selectAllPickeableItems()
{
	$("#autoTable").find("tr").each(function()
	{
		if($(this).find('.Status').text()=='Pickeable')
		{$(this).find('.Select>input').prop('checked', 'true');}
	});
}
//-------------------------------------------------------------ENDOF SELECT ALL PICKEABLE ITEMS

//-----------------------------------------------------------------------------------ITEM COUNT
/**
 * inserts a bootstrap badge containing a count of the total number of items still to invoice
 */
function itemCount()
{
	var rows = $(".Status");
	rows = (rows.length - 1); //because of list.js template
	$("h2").append("<span class='badge'>"+rows+"</span>");
}
//-----------------------------------------------------------------------------ENDOF ITEM COUNT

//-----------------------------------------------------------------------------INVOICE AND PRINT
/**
 * calls code imported from js/modules/invoiceOrders.js to invoice and print the entries whose
 * checkboxes have been ticked.
 */
function invoiceAndPrint()
{
	var orderNos="";

	$("#autoTable").find("tr").each(function()
	{
		if($(this).find('input[type="checkbox"]').is(':checked'))
		{orderNos += $(this).find('input[type="checkbox"]').prop('id')+",";}
	});
	invoiceOrders(orderNos);
}
//------------------------------------------------------------------------ENDOF INVOICE AND PRINT

//------------------------------------------------------------------------------SELECT ALL BUTTON
/**
 * adds a checkbox to the table header allowing all table entry checkboxes to be ticked/unticked
 */
function addSelectAllButton()
{
	var checkboxHTML = "<input type='checkbox' name='selectAll' value=true onchange='selectBtnFunction(this)'>"
	$("#autoTable").find("th").each(function()
	{
		if($(this).text()=='Select')
		{$(this).prepend(checkboxHTML);}
	});
}

/**
 * provides the functionality to tick/untick all checkboxes, depending on the 'checked' state of the
 * input checkbox node.
 */
function selectBtnFunction(checkbox)
{
	$("#autoTable").find("tr").each(function()
	{$(this).find('.Select>input').prop('checked', checkbox.checked);});
}
//------------------------------------------------------------------------ENDOF SELECT ALL BUTTON