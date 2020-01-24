import Component from '@ember/component';
import EmberObject, { computed } from '@ember/object';

export default Component.extend({

  tagName: 'td',
  classNames: ['map-tile'],
  classNameBindings: ['mapTileEmpty', 'mapTileSelected'],
  _markedPlayerClass: 'map-tile-player',
  objects: [],
  character: [],
  markPlayer: false,
  isSelected: false,
  x: -1,
  y: -1,

  mapTileEmpty: computed('character', function() {
    return !this.get('character');
  }),

  mapTileSelected: computed('isSelected', function() {
  console.log(this.get('isSelected') && this.get('mapTileEmpty'));
    return this.get('isSelected') && this.get('mapTileEmpty');
  }),

  markContent: computed('character', function() {
      return this.get('character') && !this.markPlayer;
  }),

  click: function(){
      this.toggleProperty('isSelected');
  }

});
