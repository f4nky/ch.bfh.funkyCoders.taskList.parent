$(document).ready(function() {
	toggleNavSidebar();
});

$(window).on('resize', function() {
	if ($(document).outerWidth() >= 768) {
		if ($('#wrapper').hasClass('toggled')) {
			$('#wrapper').removeClass('toggled');
		}
	}
});

/* === Toggle navigation sidebar === */
function toggleNavSidebar() {
	$('.navbar-toggle').click(function() {
		$('#wrapper').toggleClass('toggled');
	});
}