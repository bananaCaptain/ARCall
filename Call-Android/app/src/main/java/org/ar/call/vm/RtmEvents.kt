package org.ar.call.vm

import org.ar.rtm.LocalInvitation
import org.ar.rtm.RemoteInvitation
import org.ar.rtm.RtmChannelMember
import org.ar.rtm.RtmMessage

interface RtmEvents {
   fun onConnectionStateChanged(state:Int,reason:Int){}//连接转态改变
   fun onMessageReceived(message:RtmMessage?,uid:String?){}//收到消息
   fun onPeersOnlineStatusChanged(map:MutableMap<String,Int>?){}//通话人员状态改变
   fun onMemberJoined(member:RtmChannelMember?){}//成员加入
   fun onMemberLeft(member:RtmChannelMember?){}//成员离开
   fun onLocalInvitationReceivedByPeer(var1: LocalInvitation?){}//对等方收到的本地邀请
   fun onLocalInvitationAccepted(var1: LocalInvitation?, var2: String?){}//接受本地邀请时
   fun onLocalInvitationRefused(var1: LocalInvitation?, var2: String?){}//本地邀请被拒绝
   fun onLocalInvitationCanceled(var1: LocalInvitation?){}//本地邀请取消
   fun onLocalInvitationFailure(var1: LocalInvitation?, var2: Int){}//本地邀请失败
   fun onRemoteInvitationReceived(var1: RemoteInvitation?){}//收到远程邀请
   fun onRemoteInvitationAccepted(var1: RemoteInvitation?){}//接受远程邀请
   fun onRemoteInvitationRefused(var1: RemoteInvitation?){}//拒绝远程邀请
   fun onRemoteInvitationCanceled(var1: RemoteInvitation?){}//远程邀请取消
   fun onRemoteInvitationFailure(var1: RemoteInvitation?, var2: Int){}//远程邀请失败

}
