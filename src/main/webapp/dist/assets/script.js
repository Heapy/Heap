$("#command-line").on("submit", function(e) {
    e.preventDefault();

    console.log($("#in").val());
});