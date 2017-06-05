$(document).ready(function() {
	changePageAndSize();
});

function changePageAndSize() {
		$('#pageSizeSelect').change(function() {
		window.location.replace("?pageSize=" + this.value + "&page=1");
	});
}
