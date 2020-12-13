function addProduct(){
    let brand = $("#brand").val();
    let name = $("#name").val();
    let price = $("#price").val();
    let description = $("#description").val();
    let subCategoryID= $("#subCategoryID").val();
    let product = {
        brand:brand,
        name:name,
        price:price,
        description:description,
        subCategoryID:subCategoryID
    };

    $.ajax( {
        method: 'POST',
        url:'seller/addProduct',
        contentType: 'application/json',
        data: JSON.stringify(product)
    }).done(function(data) {
        window.location.reload();
    })
}