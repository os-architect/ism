import Component from '@ember/component';

export default Component.extend({
    classNames: ["map"],

    tiles: [],

    init() {
        this._super();
        var i =0
        var subarray = []
        for(i = 1; i<101; i++){

          subarray.push({"status": 0})

          if(i != 0 && i % 10 == 0){
            this.get('tiles').push(subarray)
            subarray = []
          }

        }
    }

});
