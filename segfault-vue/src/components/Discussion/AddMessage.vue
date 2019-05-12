<template>

<article class="media">
  <figure class="media-left">
    <p class="image is-64x64">
      <img src="https://bulma.io/images/placeholders/128x128.png">
    </p>
  </figure>
  <div class="media-content">
    <div v-if="isQuestion">
      <textarea id="newTitle" placeholder="enter a title"></textarea>
    </div>
    <div class="field">
      <p class="control">
        <textarea id="newText" class="textarea" :placeholder="'Write your '+(isQuestion? 'question':'comment')"></textarea>
      </p>
    </div>
      
    <div v-if="isQuestion">
      <p>select tags:</p>
    
      <Tag v-bind:tags="getAllTags"/>
      <textarea id="newTags" placeholder="add other tags"></textarea>
      
    </div>
    <nav class="level">
      <div class="level-left">
        <div class="level-item">
          <a class="button is-info" v-on:click="submitMsg">Submit</a>
        </div>
      </div>
      <div class="level-right" v-if="time" >
        <div class="level-item">
          <label class="checkbox">
            <input type="checkbox"/> Press enter to submit (et si c'était facultatif?)
          </label>
        </div>
      </div>
    </nav>
  </div>
</article>
</template>

<script>
import Tag from "@/components/Tag/Tag.vue";
import { mapGetters } from "vuex";
export default {
  name: "AddMessage",
  components: {
    Tag
  },
  computed: mapGetters(["getAllTags"]),
  props: ["isQuestion", "parent", "time"],
  methods: {
      submitMsg: function () {
          // ajouter tags pas présents
          if (this.isQuestion) {
            let tags = document.getElementById("newTags").value
            if (tags)
              this.$store.commit("addTags", tags)
          }
        
          // TODO envoyer requête à l'api: msg -> /discussions/new ou comment -> /messages/new
          if (this.isQuestion) {
              this.$store.commit("addMessage", {newText: document.getElementById("newText").value, user: this.$store.getters.user, parentMsg: null})
              let tagsTab = []
              document.getElementById("newTags").value.trim().split(" ").forEach((name) => tagsTab.push({nom: name}))
              tagsTab = tagsTab.concat(this.$children[0].getActivatedTags)
              this.$store.commit("addDiscussion", {id: this.$store.getters.lastId, title: document.getElementById("newTitle").value, tags: tagsTab})
//              console.log("tagsTab: " + tagsTab);
              this.$router.push('/')
          }
          else { 
            this.$store.commit("addMessage", {newText: document.getElementById("newText").value, user: this.$store.getters.user, parentMsg: this.parent})
            this.$root.$emit('msgSent')
          }
            
    }
  }
    
};
</script>
