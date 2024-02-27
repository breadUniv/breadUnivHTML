        //Image upload & delete
        document.addEventListener('DOMContentLoaded', function () {

            editProfileButton.addEventListener('click', function () {
                imageUploadInput.click();
            });

            imageUploadInput.addEventListener('change', function () {
                const selectedFile = imageUploadInput.files[0];
                if (selectedFile) {
                    var formData = new FormData(); //폼객체
                    formData.append("file",selectedFile); //name, 값
                    // formData.append("preFileName", "[[${breadUser.breadFile.profileUploadFileName}]]");

                    const imageUrl = URL.createObjectURL(selectedFile);
                    profileImage.src = imageUrl;
                    $.ajax({
                        url:'/breadEditFileUpdate',
                        type: 'post',
                        data: formData,
                        contentType:false,
                        processData:false,
                        success: function(data) {
                            // 성공했을 때
                            if(data == 'success') {
                                alert('파일변경 성공');
                            } else {
                                alert('파일변경 실패');
                            }
                        },
                        error: function(error) {
                            console.log(error);
                        }
                    });
                }
            });

            var deleteProfileButton = document.getElementById('deleteProfileButton');

            // 파일 삭제
            deleteProfileButton.addEventListener('click', function () {
                alert('프로필 삭제 버튼이 클릭되었습니다.');
                changeProfileImage(3);
            });

            function changeProfileImage(userCode) {
                console.log('changeProfileImage 함수가 호출되었습니다. 사용자 코드:', userCode);

                    $.ajax({
                        url: '/breadEditFileDelete',
                        type: 'post',
                        data: {userCode: userCode},
                        // contentType: false,
                        // processData: false,
                        success: function (data) {
                            // 성공했을 때
                            if (data == 'success') {
                                alert('파일변경 성공');
                            } else {
                                alert('파일변경 실패');
                            }
                        },
                        error: function (error) {
                            console.log(error);
                        }
                    });
                }
            });

// document.getElementById("editProfileButton").addEventListener('click',function (){
//     const a = document.getElementById('profileImage');
//     console.log(a.src);
// })
        // html
        // <div class="profileButton">
        //     <img src="/RESOURCES/IMAGE/profile/경진새.jpeg" alt="profileImage" id="profileImage">
        //     <input type="file" id="imageUploadInput" style="display: none;">
        //     <button id="editProfileButton">프로필수정</button>
        //     <button id="deleteProfileButton">프로필삭제</button>
        // </div>

