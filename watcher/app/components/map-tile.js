import Component from '@ember/component';
import EmberObject, { computed } from '@ember/object';

export default Component.extend({

  tagName: 'td',
  classNames: ['map-tile'],
  classNameBindings: ['mapTileEmpty'],
  _markedPlayerClass: 'map-tile-player',
  objects: [],
  character: [],
  markPlayer: false,
  x: -1,
  y: -1,

  mapTileEmpty: computed('character', function() {
    return !this.get('character');
  }),

  markContent: computed('character', function() {
      return this.get('character') && !this.markPlayer;
  })

});
