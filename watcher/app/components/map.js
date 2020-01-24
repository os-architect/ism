import Component from '@ember/component';
import EmberObject, { computed } from '@ember/object';

export default Component.extend({

    classNames: ["map-container"],
    map: {},

    actions: {

        submit: function(){},

        movenorth: function() {
        },
        movesouth: function() {
        },
        moveeast: function() {
        },
        movewest: function() {
        },
        stopmoving: function() {
        },

    },


    tiles: computed('map', function() {

        var tilesArray = this.get('map').tiles;
        var numRows = Math.sqrt(tilesArray.length);
        var rows = [];

        tilesArray[Math.floor(tilesArray.length/2)]["character"] = this.get('player');
        tilesArray[Math.floor(tilesArray.length/2)]["markPlayer"] = true;

        for(var i=0; i < numRows; i++) {
            rows.push(tilesArray.splice(0, numRows));
        }

        return rows;

    })

});
