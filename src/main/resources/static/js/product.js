function addProduct(productName) {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/products/" + productName);
    xhr.send();
}

function removeProduct(productName) {
    let xhr = new XMLHttpRequest();
    xhr.open("DELETE", "/products/" + productName);
    xhr.send();
}

window.onload = () => {
    const addButton = document.getElementById("addButton");
    const removeButton = document.getElementById("removeButton");
    const productCounter = document.getElementById("productCounter");
    const productName = document.getElementById("productName");

    addButton.onclick = () => {
        addProduct(productName.textContent);
        productCounter.textContent++;
    }

    removeButton.onclick = () => {
        if (productCounter.textContent < 1) return;
        removeProduct(productName.textContent);
        productCounter.textContent--;
    }
}

