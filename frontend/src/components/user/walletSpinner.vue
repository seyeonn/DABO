<template>
  <transition name="modal">
    <div class="spinner" style="text-align: center;">
      <p style="font-size: 13px;">지갑 생성까지 최대 약 10초가 소요됩니다.</p>
      <v-progress-circular
        :size="100"
        color="#f06464"
        indeterminate
      ></v-progress-circular>
    </div>
  </transition>
</template>

<script>
export default {};
</script>

<style>

</style>