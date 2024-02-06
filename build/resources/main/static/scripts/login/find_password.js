function goToLogin(){
    window.location.href = "login.html";
}

function validateForm(){ 

    // HTML에서 입력된 이름과 이메일 값을 가져옴
    var nameInput = document.getElementById('nameInputText').value;
    var emailInput = document.getElementById('emailInputText').value;
    var ccNumber= document.getElementById('ccNumber').value;
    // html에서 'Id'가 nameInputText인 요소를 찾고 그 요소의 값(value)을 'nameInput'변수에 저장함 
    // var = 변수 선언 , nameInput = 변수 이름, document.getElementById = HTML에서 특정 ID를 가진 요소를 찾는 메소드 

    //  nameInput, emailInput 중 하나다로 비어있으면 
    if (nameInput === '' || emailInput === '' || ccNumber ==='') {
        alert('공란을 확인 후 다시 눌러주세요.'); // 경고창을 띄우고 false를 반환환
        return false;
    } else {  //  nameInput, emailInput 모두 비어있지 않다면 (존재하면)
        return true; // true반환
    }
}

function numberInput() { // <<-- 인증번호를 받았다는 단순한 메시지창을 띄움 
    // 인증번호를 받는 동작을 수행 작성해야 함
    alert('인증번호를 받았습니다.');
}

function findPassword() { 
    if (validateForm()) { // validateForm 함수를 호출하여 입력값을 확인 한 후 유효하면 아래 경고창을 띄움 
        // 비밀번호 찾기 동작을 수행 작성해야함
        alert('비밀번호 찾기를 시도합니다.');
    }
}