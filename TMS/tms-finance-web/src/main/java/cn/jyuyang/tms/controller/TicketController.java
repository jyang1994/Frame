package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.dto.ResponseBean;
import cn.jyuyang.tms.entity.StoreSticket;
import cn.jyuyang.tms.entity.Ticket;
import cn.jyuyang.tms.entity.TicketInLog;
import cn.jyuyang.tms.entity.TicketOut;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.service.StoreService;
import cn.jyuyang.tms.service.TicketInLogService;
import cn.jyuyang.tms.service.TicketOutservice;
import cn.jyuyang.tms.service.TicketService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/finance/ticket")
public class TicketController {
    @Autowired
    private TicketInLogService ticketInLogService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketOutservice ticketOutservice;
    @Autowired
    private StoreService storeService;

    @GetMapping("/in/home")
    public String ticketInHome(Model model) {
        List<TicketInLog> ticketInLogs = ticketInLogService.findAllTicket();
        model.addAttribute("ticketInLogs", ticketInLogs);
        return "ticket/in/home";
    }

    @GetMapping("/in/new")
    public String ticketInNew() {
        return "ticket/in/new";
    }

    @PostMapping("/in/new")
    public String ticketInNew(TicketInLog ticketInLog, RedirectAttributes redirectAttributes) {
        try {
            if (ticketInLog == null) {
                return "ticket/in/new";
            }
            ticketInLogService.saveTicketInlog(ticketInLog);
            return "redirect:/finance/ticket/in/home";
        } catch (ServiceException ex) {

            redirectAttributes.addFlashAttribute("message", ex.getMessage());
            return "redirect:/finance/ticket/in/new";
        }

    }

    @GetMapping("/{id:\\d+}/edit")
    public String editTicketInLog(@PathVariable Integer id, Model model) {
        TicketInLog ticketInLog = ticketInLogService.selectById(id);
        model.addAttribute("ticketInLog", ticketInLog);
        return "ticket/in/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    @Transactional(rollbackFor = RuntimeException.class)
    public String editTicketInLog(@PathVariable Integer id, TicketInLog ticketInLog, RedirectAttributes redirectAttributes) {
        try {
            ticketInLogService.deleteTicketInLogAndTicketById(id);

            ticketInLogService.saveTicketInlog(ticketInLog);
            return "redirect:/finance/ticket/in/home";
        } catch (ServiceException ex) {

            redirectAttributes.addFlashAttribute("message", ex.getMessage());
            return "redirect:/finance/ticket/in/new";
        }
    }

    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean delTicketInlog(@PathVariable Integer id) {
        try {
            ticketInLogService.deleteTicketInLogAndTicketById(id);
            return ResponseBean.success();
        }catch (ServiceException ex) {
            return ResponseBean.error(ex.getMessage());
        }
    }

    @GetMapping("/all")
    public String allTicket(@RequestParam(defaultValue = "1",name = "p",required = false) Integer pageNo, Model model){
        PageInfo<Ticket> ticketPageInfo = ticketService.findTicketByPage(pageNo);
        model.addAttribute("ticketPageInfo",ticketPageInfo);
        return "ticket/in/all";
    }

    @GetMapping("/out/home")
    public String outHome(Model model){
        List<TicketOut> ticketOutList = ticketOutservice.findAllTicketOut();
        model.addAttribute("ticketOutList",ticketOutList);
        return "ticket/out/home";
    }

    @GetMapping("/out/new")
    public String newHome(Model model){
        List<StoreSticket> storeSticketList = storeService.selectAllStoreStricket();
        model.addAttribute("storeSticketList",storeSticketList);
        return "ticket/out/new";
    }

    @PostMapping("/out/new")
    public String newHome(TicketOut ticketOut,RedirectAttributes redirectAttributes){
        try{
            ticketOutservice.saveTicketOut(ticketOut);
            return "redirect:/finance/ticket/out/home";
        }catch(ServiceException ex){
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
            return "redirect:/finance/ticket/out/new";
        }

    }
    @GetMapping("/out/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean delOut(@PathVariable Integer id){
        try {
            ticketOutservice.delTicketOutById(id);
            return ResponseBean.success();
        }catch (ServiceException ex){
            return ResponseBean.error(ex.getMessage());
        }
    }

    @GetMapping("/tongji")
    public String tongjiByState(Model model){
        Map<String,Long> maps = ticketService.findTongJiByState();
        model.addAttribute("maps",maps);
        return "ticket/tongji";
    }
    @GetMapping("/out/pay")
    public String pay(Model model){
        List<TicketOut> ticketOutList = ticketOutservice.findAllTicketOut();
        model.addAttribute("ticketOutList",ticketOutList);
        return "ticket/out/pay";
    }

    @GetMapping("/out/{id:\\d+}/pay")
    @ResponseBody
    public ResponseBean payById(@PathVariable Integer id){
        try{
            ticketOutservice.payById(id);
            return ResponseBean.success();
        }catch (ServiceException ex){
            return ResponseBean.error(ex.getMessage());
        }
    }


}
