<template>
  <transition name="modal">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <!-- <button class="modal-default-button" @click="$emit('close')">
            <i style="color: #505352" class="far fa-times-circle fa-2x"></i>
          </button> -->
          <div class="modal-header">
            <slot name="header"> 헌혈증 전달중 </slot>
          </div>

          <div class="modal-body">
            
              <div class = "warning" >
              
              <div class="spinner" style="text-align: center;">
                <p style="font-size: 13px;">헌혈증 전달까지 최대 약 10초가 소요됩니다.</p>
                <p>잠시만 기다려주세요</p>
                <v-progress-circular
                  :size="100"
                  color="#f06464"
                  indeterminate
                ></v-progress-circular>
              </div>
            </div>

            <slot name="body"> </slot>
          </div>

          <div class="modal-footer">
            <slot name="footer">
              
            </slot>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
export default {};
</script>

<style scoped>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;

}
.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}
.modal-container {
  width: 340px;
  margin: 0px auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
  /* font-family: "Dancing Script", cursive; */
}
.modal-footer {
  font-family: sans-serif;
}
.modal-header {
  align-items: center;
  justify-content: center !important;
}
.modal-header h3 {
  margin-top: 0;
  color: #505352;
  text-align: center;
  font-weight: bold;
}
.modal-body {
  margin: 10px 0;
  /* text-align: center; */
}
.modal-default-button {
  float: right;
  background-color: transparent;
  border: 0;
}
.modal-enter {
  opacity: 0;
}
.modal-leave-active {
  opacity: 0;
}
.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
.modal-body,
.modal {
  color: #666 !important;
  /* font-family: "Nanumsquare", Tahoma, Geneva, Verdana, sans-serif; */
  font-size: 12px;
  
}
</style>