function handleCopyWithAuth() {
    var text = 123

    let copyHandler = copy(text)

    document.addEventListener('copy', copyHandler)
    document.execCommand('copy')
    removeEventListener('copy', copyHandler)
}

function copy(article) {
    return function (event) {
        event.clipboardData.setData("text/html", article)
        event.preventDefault()
    }
}


handleCopyWithAuth()
