$(function () {
    $( '#table' ).searchable({
        striped: true,
        oddRow: { 'background-color': '#e6e6e6' },
        evenRow: { 'background-color': '#e6e6e6' },
        searchType: 'fuzzy'
    });

});