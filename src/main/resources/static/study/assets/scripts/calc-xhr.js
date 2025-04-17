const $form = document.body.querySelector('form');
const $intro = document.getElementById('intro');
const $result = document.getElementById('result');
const $error = document.getElementById('error');


$form.onsubmit = (e) => {
    e.preventDefault();
    const xhr = new XMLHttpRequest();
    const formData = new FormData();
    formData.append('a', $form['a'].value);
    formData.append('b', $form['b'].value);
    formData.append('op', $form['op'].value);
    xhr.onreadystatechange = () => {
        if (xhr.readyState !== XMLHttpRequest.DONE) {
            return;
        }
        if (xhr.status < 200 || xhr.status > 300) {
            alert(`[${xhr.status}] 오류`);
            return;
        }
        console.log(xhr.responseText);
    };
    xhr.open('POST', location.href); // location.href
    xhr.send(formData);



}
