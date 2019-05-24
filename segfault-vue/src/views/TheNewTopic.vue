<template>
    <div class="New Topic">
     <AddMessage isQuestion="true"/>
    </div>
</template>

<script>
import AddMessage from "@/components/Discussion/AddMessage.vue";
 
export default {
  name: "New_Topic",
  components: {
    AddMessage
  },
  mounted() {
    this.$store.commit("resetActive")}
};

</script>
<style lang="scss" scoped>
</style>
