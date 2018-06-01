; (function ($, window, document, undefined) {
    //'use strict';
    var pluginName = 'vivaTimeline';//Plugin鍚嶇ū

    //Timeline寤烘寮�
    var Timeline = function (element, opt) {
        //绉佹湁璁婃暩
        this.target = element;
        this.carouselInterval;
        this.checkImgLoad;
        this.imgLoad = false;
        //鍒濆鍖�
        this._init(opt);
                    
        this._event();
        
    }

    //ImportKML2D闋愯ō鍙冩暩
    Timeline.options = {
        carousel: true,
        carouselTime: 10000
    }

    //Timeline绉佹湁鏂规硶
    Timeline.prototype = {
        //鍒濆鍖�
        _init: function (_opt) {
            //鍚堜降鑷▊鍙冩暩鑸囬爯瑷弮鏁�
            var self = this;
            self.options = $.extend(true, {}, Timeline.options, _opt);

            self.target
                .find('.events-body')
                .each(function(){
                    var rowcount = $(this).find('.row').length;
                    if(rowcount > 1) {
                        var html = "<ol>";
                        for(var i = 0; i < rowcount; i++){
                            html += "<li data-target='" + i + "'></li>";
                        }
                        html += "</ol>";
                        $(this)
                            .siblings('.events-footer')
                            .html(html)
                            .find('li')
                            .first()
                            .addClass('active');
                    }
                });
            
            self.target
                .find('.events-body')
                .each(function(){
                    $(this)
                        .find('.row')
                        .first()
                        .show()
                        .siblings()
                        .hide();  
                });              
                             
            self.target
                .find('img').on('load', function(){
                    self.target
                        .find('.events-body')
                        .each(function(){
                            var maxHeight = 0;
                            $(this)
                                .find('.row')
                                .each(function(){                                    
                                    if($(this).height() > maxHeight){
                                        maxHeight = $(this).height();
                                    }
                                });                                                        
                            $(this).find('.row').height(maxHeight);
                        });                                
                }); 
        },

        //缍佸畾浜嬩欢
        _event: function () {
            var self = this;
            self.target
                .find('.events-header')
                .click(function(){
                    $(this)
                        .siblings('.events-body').slideToggle()
                        .end()
                        .siblings('.events-footer').toggle();
                });

            self.target
                .find('.events-footer li')
                .click(function(){
                    self._carousel($(this));
                });

            if(self.options.carousel){
                self.carouselInterval = setInterval(function(){
                    self._carousel();
                }, self.options.carouselTime);

                self.target
                    .find('.events')
                    .hover(function(){
                        clearInterval(self.carouselInterval);
                        self.carouselInterval = null;
                        
                    }, function(){
                        if(self.carouselInterval == undefined){
                            self.carouselInterval = setInterval(function(){
                                self._carousel();
                            }, self.options.carouselTime);
                        }
                    });
            }
        },
        
        //鑷嫊杓挱
        _carousel: function(_container) {
            var self = this;
            if(_container == undefined){
                self.target
                    .find('.events-footer .active')
                    .each(function(){
                        var nextTarget;
                        if($(this).is(':last-child')){
                            nextTarget = $(this).siblings().first();
                        }
                        else{
                            nextTarget = $(this).next();
                        }
                        self._carousel(nextTarget);
                    });
            }
            else{
                var target = _container.data().target;

                _container
                    .addClass('active')
                    .siblings()
                    .removeClass('active');
                    
                _container
                    .closest('.events-footer')
                    .siblings('.events-body')
                    .find('.row')
                    .eq(target).show()
                    .siblings().hide();  
            }
        }
    }

    //鍏枊鏂规硶
    $.fn[pluginName] = function (options, args) {
        var timeline;
        this.each(function () {
            timeline = new Timeline($(this), options);
        });
        return this;
    }
})(jQuery, window, document);