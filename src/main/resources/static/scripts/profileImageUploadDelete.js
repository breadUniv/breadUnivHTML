        //Image upload & delete
        document.addEventListener('DOMContentLoaded', function () {

            editProfileButton.addEventListener('click', function () {
                imageUploadInput.click();
            });
        
            imageUploadInput.addEventListener('change', function () {
                const selectedFile = imageUploadInput.files[0];
                if (selectedFile) {
        
                    const imageUrl = URL.createObjectURL(selectedFile);
                    profileImage.src = imageUrl;
                }
            });
        
            deleteProfileButton.addEventListener('click', function () {
                profileImage.src = "/RESOURCES/IMAGE/profile/none.png";
            });
        });

        // html
        // <div class="profileButton">
        //     <img src="/RESOURCES/IMAGE/profile/경진새.jpeg" alt="profileImage" id="profileImage">
        //     <input type="file" id="imageUploadInput" style="display: none;">
        //     <button id="editProfileButton">프로필수정</button>
        //     <button id="deleteProfileButton">프로필삭제</button>
        // </div>

