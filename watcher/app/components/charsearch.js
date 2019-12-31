import Component from '@ember/component';

export default Component.extend({

    form: null,
    name: "",

    actions: {
        search() {
          alert(this.get('name'))
        }
    }

});
