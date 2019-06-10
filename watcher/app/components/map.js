import Component from '@ember/component';
import EmberObject, { computed } from '@ember/object';

export default Component.extend({
    classNames: ["map"],

    map: {},

    willRender() {

        var cols = Math.sqrt(this.get('map').tiles.length)

        // add player indication to player tile
        var playerY = this.get('player').position.y;
        var playerX = this.get('player').position.x;

        var playerTile = this.get('map').tiles[(((playerY * cols) + playerX ))]
        playerTile ["player"] = this.get('player')

    },

    tiles: computed('map', function() {

        var tilesArray = this.get('map').tiles
        console.log(tilesArray.length)
        var numRows = Math.sqrt(tilesArray.length)
        console.log(numRows)
        var rows = []

        for(var i=0; i<numRows; i++){
            rows.push(tilesArray.splice(0, numRows))
        }

        console.log(rows)

        return rows

    })

});
