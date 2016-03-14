package com.realaicy.tna.demos.webshowcase.common.web;

import com.realaicy.tna.modules.core.orm.AbstractEntity;
import com.realaicy.tna.modules.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * Created by realaicy on 2016/3/14.
 */

public abstract class BaseCRUDController<M extends AbstractEntity, ID extends Serializable>
        extends BaseController<M, ID> {


    protected final static String REDIRECT = "redirect:";
    protected final static String SUCCESS = "success";


    protected String listView = null;
    protected String editView = null;
    protected String showView = null;


    @Autowired
    private BaseService<M, ID> baseService;

    /**
     * 跳转到添加页面
     *
     * @return xxx
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public ModelAndView create() throws Exception {
        return new ModelAndView(editView);
    }

    /**
     * 添加
     *
     * @param object xx
     * @return xxx
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public String create(@Valid M object) throws Exception {
        baseService.save(object);
        return REDIRECT + listView;
    }

    /**
     * 跳转到更新页面
     *
     * @param id xxx
     * @return xxx
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/update/{id}")
    public ModelAndView update(@PathVariable("id") ID id) throws Exception {
        M obj = baseService.get(id);
        ModelAndView mav = new ModelAndView(editView);
        mav.addObject("obj", obj);
        return mav;
    }

    /**
     * 删除
     *
     * @param id xxx
     * @return xxx
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") ID id, RedirectAttributes redirectAttributes) throws Exception {
        baseService.removeById(id);
        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "删除成功");
        return REDIRECT + listView;
    }

    /**
     * 批量删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("ids") ID[] ids, RedirectAttributes redirectAttributes) throws Exception {
        baseService.removeByIds(ids);
        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "批量删除成功");
        return REDIRECT + listView;
    }

    /**
     * 展示
     *
     * @param id xxx
     * @return xxx
     * @throws Exception
     */
    @RequestMapping(value = "/show/{id}")
    public ModelAndView show(@PathVariable("id") ID id) throws Exception {
        M object = baseService.get(id);
        ModelAndView mav = new ModelAndView(showView);
        mav.addObject("obj", object);
        return mav;
    }


    /**
     * Readme string.
     *
     * @return the string
     */
    @RequestMapping(value = "/api/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<M> ListAll() {
        return baseService.getAll();
    }

    @RequestMapping(value = "/*")
    public String list() {
        return listView;
    }

    /**
     * 设置基础service
     *
     * @param baseService xxx
     */
    @Autowired
    public void setBaseService(BaseService<M, ID> baseService) {
        this.baseService = baseService;
    }


}


