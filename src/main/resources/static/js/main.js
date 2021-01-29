function submitEditEnable() {
    $('#insetSubmit').addClass('d-none');
    $('#insetEnable').removeClass('d-none');
    $('#deleteSubmit').removeClass('d-none');
    $('#updateSubmit').removeClass('d-none');
}
function submitInsertEnable() {
    $('#insetSubmit').removeClass('d-none');
    $('#insetEnable').addClass('d-none');
    $('#deleteSubmit').addClass('d-none');
    $('#updateSubmit').addClass('d-none');
    $('.fluid-form').find('input').val('');
    $('#id').val(1);
}

let memberTable = {
    $res : null,
    init : function() {
        this.cacheDom();
        this.bindEvents();
    },
    cacheDom : function() {
        $res = $('#memberTable');
    },
    bindEvents: function() {
        $res.on('click', 'button[name=action]', this.sendData.bind(this));
    },
    sendData : function(event) {
        let $row = $(event.target).closest('tr');
        $("#id").val($row.find('td:eq(0)').text());
        $("#emailAddress").val($row.find('td:eq(1)').text());
        $("#firstName").val($row.find('td:eq(2)').text());
        $("#lastName").val($row.find('td:eq(3)').text());
        $("#telephone").val($row.find('td:eq(4)').text());
    }
};
memberTable.init();