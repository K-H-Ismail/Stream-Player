$( "#userpanel" ).hide();
$( "#roomspanel" ).hide();
$( "#settingspanel" ).hide();

$( "#users" ).click(function() {
$( "#userpanel" ).toggle( "slow", function() {
// Animation complete.
});
});

$( "#room" ).click(function() {
$( "#roomspanel" ).toggle( "slow", function() {
// Animation complete.
});
});

$( "#settings" ).click(function() {
$( "#settingspanel" ).toggle( "slow", function() {
// Animation complete.
});
});

$( "#save" ).click(function() {
$( "#settingspanel" ).hide( "slow", function() {
// Animation complete.
});
});