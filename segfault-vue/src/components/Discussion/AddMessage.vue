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
        <textarea id="newText" class="textarea" :placeholder="'Write your '+(isQuestion? 'question':'comment')" autofocus></textarea>
      </p>
    </div>
      
    <div v-if="isQuestion">
      <p>select tags:</p>
    
      <Tag v-bind:tags="getAllTags"/>
      <p>Add other tags:</p>
      <textarea id="newTags" placeholder="all white spaces are removed, split tags with #"></textarea>
      
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
  computed: mapGetters(["getAllTags", "apiURL"]),
  props: ["isQuestion", "parent", "time"],
  methods: {
    submitMsg: async function () {

      const text = document.getElementById("newText").value
        if (! text) {
          this.$store.dispatch("displayError", "cannot add empty message!")
          return
        }
    
      if (this.isQuestion) {
  
        const title = document.getElementById("newTitle").value
        if (! title) {
          this.$store.dispatch("displayError", "cannot add empty title!")
          return
        }
        // need at least 1 tag prio
        if (this.$store.getters.getActivatedTags.filter(tag => tag.prio).length == 0) {
          this.$store.dispatch("displayError", "you should select at least one mandatory tag. (dark blue)")
          return
        }
    
        // adding new tags to db and store 
        let tags = document.getElementById("newTags").value
        if (tags)
          await this.$store.dispatch("addTags", tags)
          
        this.$store.dispatch("newDiscussion", { 
          title: title, 
          text: text, 
          tags: this.$store.getters.getActivatedTags.map(tag => tag.id), 
          userId: this.$store.getters.user.utilisateurID
        })
        
      }
      else { 
        
        this.$store.dispatch("newMessage", {
          newText: text,
          parentMsg: this.parent
        })
        // to hide the text field
        this.$root.$emit('msgSent')
      }
    }
  },
  created () {
    if (!this.$store.getters.getAllTags.length)
      this.$store.dispatch ("fetchTags")
  }
    
};
</script>

<style>
  textarea {min-width: 50vw;}
</style>