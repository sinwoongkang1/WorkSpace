function fetchProducts() {
    fetch('/api/products')
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById('productList');
            list.innerHTML = '';
            data.forEach(product => {
                const item = document.createElement('li');
                item.textContent = `Name: ${product.name}, Price: ${product.price}`;
                list.appendChild(item);
            });
        });
}
function addProduct() {
    const name = document.getElementById('productName').value;
    const price = document.getElementById('productPrice').value;

    fetch('/api/products', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name: name, price: price })
    }).then(() => {
        fetchProducts();  // Refresh the list
        document.getElementById('productName').value = '';  // Clear the input
        document.getElementById('productPrice').value = '';  // Clear the input
    });
}

document.addEventListener('DOMContentLoaded', function () {
    fetchProducts();
});