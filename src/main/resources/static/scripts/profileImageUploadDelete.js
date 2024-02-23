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
                        error: function(error) {1
                            console.log(error);
                        }
                    })
                }
            });

            deleteProfileButton.addEventListener('click', function () {
                profileImage.src = "/images/profile/none.png";
            });
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

