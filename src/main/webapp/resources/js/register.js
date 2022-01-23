const imageFile = document.getElementById("image");

imageFile.onchange = function () {
    const maxAllowedSize = 300 * 1024;
    if (this.files[0].size > maxAllowedSize) {
        alert("Image File is too big!");
        this.value = "";
    }
}