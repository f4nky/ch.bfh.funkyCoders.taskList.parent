$(document).ready(function() {
	toggleNavSidebar();
});

/* === Toggle navigation sidebar === */
function toggleNavSidebar() {
	$('.navbar-toggle').click(function() {
		$('#wrapper').toggleClass('toggled');
	});
}