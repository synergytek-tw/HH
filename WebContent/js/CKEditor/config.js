/**
 * @license Copyright (c) 2003-2014, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
	
	config.toolbarGroups = [
	    { name: 'document',    groups: [ 'mode', 'document', 'doctools' ] },
	    { name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		//{ name: 'links' },
		{ name: 'insert' },
		//{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		//{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' },
		//{ name: 'about' }
	];

	/*
	config.toolbar = [
	                  ['Source', 'Preview',
	                   	'-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord',
	                   	'-', 'Undo', 'Redo',
	                   	'-', 'Print'],
	                  '/',['Bold', 'Italic']
	                  /*{ name: 'document', items: [ 'Source', '-', 'NewPage', 'Preview', '-', 'Templates' ] },
					  { name: 'clipboard', items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
					  '/',
					  { name: 'basicstyles', items: [ 'Bold', 'Italic' ] }* /
				  ];*/
};
