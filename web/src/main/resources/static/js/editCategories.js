function deleteSubCategory(){
    let id = $("#deleteSubCat").val();
    let subcategory = {
        id:id
    };

    $.ajax( {
        method: 'POST',
        url:'admin/deleteSubCategory',
        contentType: 'application/json',
        data: JSON.stringify(subcategory)
    }).done(function(data) {
        window.location.reload();
    })
}
function deleteCategory(){
    let id = $("#deleteCat").val();
    let category = {
        id:id
    };

    $.ajax( {
        method: 'POST',
        url:'admin/deleteCategory',
        contentType: 'application/json',
        data: JSON.stringify(category)
    }).done(function(data) {
        window.location.reload();
    })
}
function addCategory(){
    let name = $("#category-form-name").val();
    let category = {
        name:name
    };

    $.ajax( {
        method: 'POST',
        url:'admin/addCategory',
        contentType: 'application/json',
        data: JSON.stringify(category)
    }).done(function(data) {
        window.location.reload();
    })
}